package com.murphy.ratelimiter.core;/**
 * @author dongsufeng
 * @date 2019/11/29 11:32
 * @version 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 *
 * @author dongsufeng
 * @date 2019/11/29 11:32
 * @version 1.0
 */
@Component
public class RateLimiterRunner {

	private ExecutorService executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),Runtime.getRuntime().availableProcessors(),
			0L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>());


	@Autowired
	private RedisRateLimiter redisRateLimiter;


	/**
	 * 是否允许通过（是否限流）
	 * @return
	 */
	public boolean checkRun(String key,int permits,int time, TimeUnit timeUnit){
		try {
			CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(()-> redisRateLimiter.acquire(key, permits, time,timeUnit), executorService);
//			Future<Boolean> future = executorService.submit(new CheckTask(key, permits, time,timeUnit));
			return future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return false;
	}
	class CheckTask implements Callable<Boolean>{
		private String key;
		private int permits;
		private int time;
		private TimeUnit timeUnit;

		public CheckTask(String key, int permits, int time, TimeUnit timeUnit) {
			this.key = key;
			this.permits = permits;
			this.time = time;
			this.timeUnit = timeUnit;
		}

		@Override
		public Boolean call() {
			return  redisRateLimiter.acquire(key, permits, time,timeUnit);
		}
	}
}
