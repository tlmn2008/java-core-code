
1. Sctp服务器端：
SctpServerChannel sctpServerChannel = SctpServerChannel.open();

sctpServerChannel.bind(serverSocketAddress);
sctpServerChannel.configureBlocking(false);
sctpServerChannel.register(selector, SelectionKey.OP_ACCEPT);


上面是在 SctpServerChannel 上注册了accept事件，然后有一个accept就会创建一个SctpChannel，
SctpChannel sctpChannel = ((SctpServerChannel) key.channel()).accept();
这个SctpChannel是和客户端的SctpChannel链接的。保存有对端的地址。通过sctpChannel.getRemoteAddresses()可以拿到。


2. 客户端
sctpChannel = SctpChannel.open().bind(clientAddress);
sctpChannel.connect(serverAddress, 1, 1);


需要注意的是：当客户端的sctpChannel关闭后，服务器端对应的SctpChannel的getRemoteAddresses函数会拿不到地址，
这应该是由于断开链接而清除了地址。
