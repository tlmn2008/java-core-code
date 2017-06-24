package kenny.io.sctp;

import com.sun.nio.sctp.MessageInfo;
import com.sun.nio.sctp.SctpChannel;
import com.sun.nio.sctp.SctpServerChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.*;

public class SctpServer {

    private final InetSocketAddress serverSocketAddress;
    private int index = 0;
    private Selector selector;
    private Map<String, SctpChannel> sctpChannelMap = new HashMap<>();

    public SctpServer(final InetSocketAddress serverSocketAddress) throws IOException {
        this.serverSocketAddress = serverSocketAddress;
        try {
            selector = Selector.open();
            System.out.println("Selector.open()");
        } catch (IOException e) {
            final String message = "Failed to open a selector.";
            throw new IOException(message, e);
        }
    }

    public void run() throws IOException {
        SctpServerChannel sctpServerChannel = null;
        try {
            sctpServerChannel = SctpServerChannel.open().bind(serverSocketAddress);
            sctpServerChannel.configureBlocking(false);
            sctpServerChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectedKeys.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    // handle the selection key
                    handleSelectionKey(key);
                    it.remove();
                }
            }
        } catch (Exception ignored) {
            System.out.println("Exception:" + ignored.toString());
        } finally {
            try {
                selector.close();
                System.out.println("selector.close()");
                if (sctpServerChannel != null) {
                    sctpServerChannel.close();
                    System.out.println("sctpServerChannel.close()");
                }
            } catch (IOException ignored) {

            }
        }
    }

    private void handleSelectionKey(SelectionKey key) throws IOException, InterruptedException {
        if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
            System.out.println("SelectionKey.OP_ACCEPT");
            SctpChannel sctpChannel = ((SctpServerChannel) key.channel()).accept();
            sctpChannel.configureBlocking(false);
            sctpChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("address: " + sctpChannel.getRemoteAddresses());
            sctpChannelMap.put("" + index++, sctpChannel);
        } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
            System.out.println("SelectionKey.OP_READ");
            SctpChannel sctpChannel = (SctpChannel) key.channel();
            if (sctpChannel != null) {
                //省略
            }
        }
    }

    public void wakeup() {
        selector.wakeup();
        System.out.println("selector.wakeup()");
    }
}
