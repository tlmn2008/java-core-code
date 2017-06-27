避免 Random 实例被多线程使用，虽然共享该实例是线程安全的，但会因竞争同一seed导致性能下降。
Random 实例包括 java.util.Random 的实例或者 Math.random()实例。
在 JDK7 之后，可以直接使用 API ThreadLocalRandom，在 JDK7 之前，可以做到每个线
程一个实例。