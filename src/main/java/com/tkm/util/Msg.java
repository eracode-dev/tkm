package com.tkm.util;

import org.bukkit.ChatColor;

/**
 * Mesaj / renk yardımcısı.
 */
public final class Msg {

    private Msg() {}

    public static String color(String s) {
        if (s == null) return "";
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String formatNumber(double d) {
        if (d == (long) d) {
            return String.format("%,d", (long) d).replace(',', '.');
        }
        return String.valueOf(d);
    }

    /**
     * Türkçe/İngilizce miktar ayrıştırma.
     * - "10.000" -&gt; 10000 (binlik nokta)
     * - "10.000,50" -&gt; 10000.5 (binlik nokta + ondalık virgül)
     * - "15000" -&gt; 15000, "10.5" -&gt; 10.5
     * - "10.000 TL" -&gt; 10000 (TL eki ve boşluklar atılır)
     */
    public static double parseAmount(String raw) throws NumberFormatException {
        if (raw == null) throw new NumberFormatException("null amount");
        String s = raw.trim().replace(" ", "").replace("TL", "").replace("tl", "").replace("Tl", "").trim();
        if (s.isEmpty()) throw new NumberFormatException("empty amount");
        if (s.contains(",")) {
            // Türkçe format: noktalar binlik, virgül ondalık
            s = s.replace(".", "").replace(",", ".");
        } else if (s.matches("^\\d{1,3}(\\.\\d{3})+$")) {
            // 10.000 / 1.000.000 gibi binlik nokta
            s = s.replace(".", "");
        }
        double d = Double.parseDouble(s);
        if (Double.isNaN(d) || Double.isInfinite(d)) throw new NumberFormatException("invalid amount");
        return d;
    }
}
