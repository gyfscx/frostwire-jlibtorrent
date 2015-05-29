package com.frostwire.jlibtorrent.demo;

import com.frostwire.jlibtorrent.AlertListener;
import com.frostwire.jlibtorrent.PeerConnection;
import com.frostwire.jlibtorrent.Session;
import com.frostwire.jlibtorrent.TorrentHandle;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.plugins.*;

import java.io.File;

/**
 * @author gubatron
 * @author aldenml
 */
public final class PluginsTest {

    public static void main(String[] args) throws Throwable {

        final Session s = new Session();

        Plugin p = new AbstractPlugin() {
            @Override
            public TorrentPlugin newTorrent(TorrentHandle th) {
                return new AbstractTorrentPlugin() {

                    @Override
                    public PeerPlugin newPeerConnection(PeerConnection pc) {
                        return new AbstractPeerPlugin() {
                            @Override
                            public void tick() {
                                System.out.println("PeerPlugin: tick");
                            }
                        };
                    }

                    @Override
                    public void tick() {
                        System.out.println("TorrentPlugin: tick");
                    }

                    @Override
                    public void onPiecePass(int index) {
                        System.out.println("TorrentPlugin: onPiecePass(" + index + ")");
                    }
                };
            }

            @Override
            public void onTick() {
                System.out.println("Plugin: onTick");
            }
        };

        SwigPlugin sp = new SwigPlugin(p);

        s.getSwig().add_swig_extension(sp);

        s.addListener(new AlertListener() {
            @Override
            public int[] types() {
                return null;
            }

            @Override
            public void alert(Alert<?> alert) {
                //System.out.println(alert.getType() + " - " + alert.getSwig().what() + " - " + alert.getSwig().message());
            }
        });

        File torrentFile = new File("/Users/aldenml/Downloads/test.torrent");
        final TorrentHandle th = s.addTorrent(torrentFile, torrentFile.getParentFile());

        th.resume();

        System.out.println("Press ENTER to exit");
        System.in.read();
    }
}