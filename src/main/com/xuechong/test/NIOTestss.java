package com.xuechong.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.xuechong.utils.http.mapping.Parameter;

public class NIOTestss {

	static int i = 0;
	static Selector selector;
	static ThreadPool pool = new ThreadPool(10);
	static Worker worker = new Worker(pool);

	static {
		worker.start();
		try {
			selector = Selector.open();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		for (; i < 100; i++) {
			// postRequest("http://zh.moegirl.org/", null);
			postRequest("http://127.0.0.1:8888/", null);
			System.out.println(i);
		}

	}

	public static void postRequest(String url, Collection<Parameter> params)
			throws IOException {
		URL u = new URL(url);
		if (!u.getProtocol().equalsIgnoreCase("http")) {
			System.err.println("Sorry, " + u.getProtocol()
					+ " is not supported");
			return;
		}
		String host = u.getHost();
		int port = u.getPort();
		String file = u.getFile();
		if (file == null)
			file = "/";
		if (port <= 0)
			port = 80;
		SocketAddress remote = new InetSocketAddress(host, port);
		SocketChannel channel = SocketChannel.open(remote);
		SelectableChannel sc = channel;
		sc.configureBlocking(false);

		String request = "POST "
				// +
				// "/api.php?format=json&action=opensearch&search=黑雪姬&namespace=0"
				+ "/asd" + " HTTP/1.1\r\n" + "User-Agent: HTTPGrab\r\n"
				+ "Accept: text/*\r\n" + "Connection: close\r\n" + "Host: "
				+ host + "\r\n" + "\r\n";
		ByteBuffer header = ByteBuffer.wrap(request.getBytes("UTF-8"));
		SelectionKey key = channel.register(selector, SelectionKey.OP_WRITE);
		worker.serviceChannel(key, header);
	}

}

class Worker extends Thread {

	private volatile SelectionKey key = null;
	private volatile ByteBuffer bytes = null;
	private volatile int t = 0;
	private ThreadPool pool = null;

	public Worker(ThreadPool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		System.out.println(this.getName() + " is ready");
		while (true) {
			try {
				// Sleep and release object lock
				synchronized (this) {
					this.wait(0);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				// Clear interrupt status
				this.interrupted();
			}
			if (key == null || bytes == null) {
				
				System.err.println("null!");
				continue; /* just in case */
			}
			System.out.println(key);
			System.out.println(bytes.hasRemaining());

			System.out.println(this.getName() + " has been awakened" + (++t));
			try {
				SocketChannel channel = (SocketChannel) key.channel();
				channel.write(bytes);
				FileOutputStream out = new FileOutputStream(
						"f:/nioresults/results" + NIOTestss.i + ".txt");
				FileChannel localFile = out.getChannel();
				ByteBuffer buffer = ByteBuffer.allocate(1024 * 8);
				while (channel.read(buffer) != -1) {
					// System.err.println(buffer);
					buffer.flip();
					localFile.write(buffer);
					buffer.clear();
				}
				localFile.close();
			} catch (Exception e) {
				// System.out.println("Caught '" + e + "' closing channel");
				// Close channel and nudge selector
				try {
					key.channel().close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				key.selector().wakeup();
			}
			key = null;
			bytes = null;

			this.pool.returnWorker(this);
		}
	}

	synchronized void serviceChannel(SelectionKey key, ByteBuffer bytes) {
		this.key = key;
		this.bytes = bytes;
		key.interestOps(key.interestOps() & (~SelectionKey.OP_READ));
		this.notify(); // Awaken the thread
	}

}

class ThreadPool {
	List idle = new LinkedList();

	ThreadPool(int poolSize) {
		// Fill up the pool with worker threads
		for (int i = 0; i < poolSize; i++) {
			Worker thread = new Worker(this);
			// Set thread name for debugging. Start it.
			thread.setName("Worker" + (i + 1));
			thread.start();
			idle.add(thread);
		}
	}

	/**
	 * Find an idle worker thread, if any. Could return null.
	 */
	Worker getWorker() {
		Worker worker = null;
		synchronized (idle) {
			if (idle.size() > 0) {
				worker = (Worker) idle.remove(0);
			}
		}
		return (worker);
	}

	/**
	 * Called by the worker thread to return itself to the idle pool.
	 */
	void returnWorker(Worker worker) {
		synchronized (idle) {
			idle.add(worker);
		}
	}
}
