package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.alerts.SessionStatsAlert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gubatron
 * @author aldenml
 */
public final class SessionStats {

    private static final StatsMetric[] STATS_METRICS = LibTorrent.sessionStatsMetrics();

    public static final int DHT_NODES_IDX = LibTorrent.findMetricIdx("dht.dht_nodes");
    public static final int RECV_PAYLOAD_BYTES_IDX = LibTorrent.findMetricIdx("net.recv_payload_bytes");
    public static final int SENT_PAYLOAD_BYTES_IDX = LibTorrent.findMetricIdx("net.sent_payload_bytes");
    public static final int RECV_BYTES_IDX = LibTorrent.findMetricIdx("net.recv_bytes");
    public static final int SENT_BYTES_IDX = LibTorrent.findMetricIdx("net.sent_bytes");

    public static final int TOTAL_DOWNLOAD_RATE_IDX = LibTorrent.findMetricIdx("net.total_download_rate");
    public static final int TOTAL_UPLOAD_RATE_IDX = LibTorrent.findMetricIdx("net.total_upload_rate");
    public static final int PAYLOAD_DOWNLOAD_RATE_IDX = LibTorrent.findMetricIdx("net.payload_download_rate");
    public static final int PAYLOAD_UPLOAD_RATE_IDX = LibTorrent.findMetricIdx("net.payload_upload_rate");
    public static final int IP_OVERHEAD_DOWNLOAD_RATE_IDX = LibTorrent.findMetricIdx("net.ip_overhead_download_rate");
    public static final int IP_OVERHEAD_UPLOAD_RATE_IDX = LibTorrent.findMetricIdx("net.ip_overhead_upload_rate");

    private final long[] values;

    SessionStats() {
        this.values = null;
    }

    SessionStats(SessionStatsAlert alert) {
        if (alert == null) {
            throw new IllegalArgumentException("alert can't be null");

        }
        this.values = new long[STATS_METRICS.length];

        for (int i = 0; i < STATS_METRICS.length; i++) {
            int index = STATS_METRICS[i].valueIndex;
            if (index < values.length) {
                values[index] = alert.value(index);
            } // TODO: Review this if
        }
    }

    public long value(int valueIdx) {
        if (values == null) {
            return 0;
        }

        return values[valueIdx];
    }

    public Map<String, Long> nonZeroValues() {
        if (values == null) {
            return Collections.emptyMap();
        }

        HashMap<String, Long> m = new HashMap<String, Long>();

        for (StatsMetric sm : STATS_METRICS) {
            long value = values[sm.valueIndex];
            if (value != 0) {
                m.put(sm.name, value);
            }
        }

        return Collections.unmodifiableMap(m);
    }

    /**
     * NOTE: This method returns always zero due due to the way it's
     * implemented in libtorrent.
     *
     * @return
     */
    public long getDHTNodes() {
        return value(DHT_NODES_IDX);
    }

    public long getPayloadDownload() {
        return value(RECV_PAYLOAD_BYTES_IDX);
    }

    public long getPayloadUpload() {
        return value(SENT_PAYLOAD_BYTES_IDX);
    }

    public long getTotalDownload() {
        return value(RECV_BYTES_IDX);
    }

    public long getTotalUpload() {
        return value(SENT_BYTES_IDX);
    }

    public long totalDownloadRate() {
        return value(TOTAL_DOWNLOAD_RATE_IDX);
    }

    public long totalUploadRate() {
        return value(TOTAL_UPLOAD_RATE_IDX);
    }
}