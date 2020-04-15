package jmh.main

import util.Random

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Array(Mode.Throughput))
class SolutionBenchmark:

  def randomArray: Array[Int] =
    val n = 100
    var arr1 = Array.range(1, n + 2)
    val v = arr1(Random.nextInt(arr1.size))
    val arr2 = Array.fill(n - 1)(v)
    val arr = arr1 ++ arr2
    arr
  
  def generate = 
    val arr = randomArray
    val vec = arr.toVector
    (arr, vec)

  @Benchmark
  def solution0Kotlin(blackhole: Blackhole): Unit =
    val (arr, _) = generate
    val r = main.Solution0_kotlin.repeatedNTimes(arr)
    blackhole.consume(r)

  @Benchmark
  def solution0Java(blackhole: Blackhole): Unit =
    val (arr, _) = generate
    val r = main.Solution0_java.repeatedNTimes(arr)
    blackhole.consume(r)
  
  @Benchmark
  def solution1(blackhole: Blackhole): Unit =
    val (arr, _) = generate
    val r = main.Solution1.repeatedNTimes(arr)
    blackhole.consume(r)

  @Benchmark
  def solution2(blackhole: Blackhole): Unit =
    val (_, vec) = generate
    val r = main.Solution2.repeatedNTimes(vec)
    blackhole.consume(r)
  
  @Benchmark
  def solution3(blackhole: Blackhole): Unit =
    val (_, vec) = generate
    val r = main.Solution3.repeatedNTimes(vec)
    blackhole.consume(r)
  
  @Benchmark
  def solution4(blackhole: Blackhole): Unit =
    val (_, vec) = generate
    val r = main.Solution4.repeatedNTimes(vec)
    blackhole.consume(r)
  
  @Benchmark
  def solution5(blackhole: Blackhole): Unit =
    val (_, vec) = generate
    val r = main.Solution5.repeatedNTimes(vec)
    blackhole.consume(r)
  
  @Benchmark
  def solution6(blackhole: Blackhole): Unit =
    val (_, vec) = generate
    val r = main.Solution6.repeatedNTimes(vec)
    blackhole.consume(r)
