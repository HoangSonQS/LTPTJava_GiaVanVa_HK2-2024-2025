package iuh.fit.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class for generating consistent serialVersionUID values.
 * This helps ensure compatibility between server and client when using RMI.
 */
public class SerializationUtils {

    /**
     * Constants for serialVersionUID values for all entity classes.
     * These values should be used in all entity classes to ensure
     * compatibility between server and client.
     */
    public static final long TAIKHOAN_SERIAL_VERSION_UID = 1L;
    public static final long CALAM_SERIAL_VERSION_UID = 2L;
    public static final long HOADON_SERIAL_VERSION_UID = 3L;
    public static final long SANPHAM_SERIAL_VERSION_UID = 4L;
    public static final long KHACHHANG_SERIAL_VERSION_UID = 5L;
    public static final long PHIEUNHAPHANG_SERIAL_VERSION_UID = 6L;
    public static final long NHANVIEN_SERIAL_VERSION_UID = 7L;
    public static final long CHITIETHOADON_SANPHAM_SERIAL_VERSION_UID = 8L;
    public static final long CHITIETHOADON_SANPHAMID_SERIAL_VERSION_UID = 9L;
    public static final long CHITIETSANPHAM_PHIEUNHAP_SERIAL_VERSION_UID = 10L;
    public static final long CHITIETSANPHAM_PHIEUNHAPID_SERIAL_VERSION_UID = 11L;

    /**
     * Generates a consistent serialVersionUID for a class based on its name.
     * This ensures that the same class will have the same serialVersionUID
     * on both the server and client side.
     *
     * @param className The fully qualified name of the class
     * @return A long value to use as serialVersionUID
     */
    public static long generateSerialVersionUID(String className) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(className.getBytes());

            // Convert the first 8 bytes to a long
            long result = 0;
            for (int i = 0; i < Math.min(8, bytes.length); i++) {
                result = (result << 8) | (bytes[i] & 0xff);
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            // Fallback to a simple hash if MD5 is not available
            return className.hashCode();
        }
    }

    /**
     * Computes the serialVersionUID for a class by serializing an instance
     * and generating a hash from the serialized form.
     *
     * @param obj An instance of the class
     * @return A long value to use as serialVersionUID
     */
    public static long computeSerialVersionUID(Serializable obj) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();

            byte[] bytes = baos.toByteArray();
            long hash = 0;
            for (int i = 0; i < bytes.length; i++) {
                hash = 31 * hash + bytes[i];
            }
            return hash;
        } catch (IOException e) {
            return obj.getClass().getName().hashCode();
        }
    }
}
