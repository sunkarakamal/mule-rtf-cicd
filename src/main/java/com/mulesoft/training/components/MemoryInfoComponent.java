package com.mulesoft.training.components;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.HashMap;
import java.util.Map;

public class MemoryInfoComponent {

	private static final long MB = 1024L * 1024L;

	public static Map<String, String> getMemoryStats() throws Exception {
		final Runtime rt = Runtime.getRuntime();
		final MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
		final long usedMemory = rt.totalMemory() - rt.freeMemory();

		final Map<String, String> memoryStats = new HashMap<String, String>();
		memoryStats.put("JVM total memory", (rt.totalMemory() / MB) + " MB");
		memoryStats.put("JVM used memory", (usedMemory / MB) + " MB");
		memoryStats.put("JVM free memory", (rt.freeMemory() / MB) + " MB");
		memoryStats.put("Heap init size", (mbean.getHeapMemoryUsage().getInit() / MB) + " MB");
		memoryStats.put("Heap max size", (mbean.getHeapMemoryUsage().getMax() / MB) + " MB");
		memoryStats.put("Heap used size", (mbean.getHeapMemoryUsage().getUsed() / MB) + " MB");
		memoryStats.put("Heap commited", (mbean.getHeapMemoryUsage().getCommitted() / MB) + " MB");
		return memoryStats;
	}

}
