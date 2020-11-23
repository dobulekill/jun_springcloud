package org.nr.tour.common.util;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Wujun
 */
public interface ImageService {
    /**
     * 增加水印
     *
     * @param source
     * @param waterMark
     * @param x
     * @param y
     */
    void addWatermark(InputStream source, InputStream waterMark, OutputStream outputStream, int x, int y);
}
