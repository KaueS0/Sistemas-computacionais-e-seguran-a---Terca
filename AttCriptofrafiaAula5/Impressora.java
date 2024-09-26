public class Impressora {
  public String hexBytesToString(byte[] b) {
    String sOut = "";
    String sBgn = "";
    String sMd1 = "";
    String sEnd = "";
    String sSpc = "                                               ";
    for (int i = 0; i < b.length; i++) {
      if (i % 16 == 0)
        sBgn += Integer.toHexString(i & 0xFFFF | 0X10000).substring(1, 5) + " - ";

      sMd1 += Integer.toHexString(b[i] & 0xFF | 0x100).substring(1, 3) + " ";

      if (b[i] >= 32 && b[i] <= 126)
        sEnd += (char) b[i];
      else
        sEnd += ".";

      if ((i % 16 == 15) || (i == b.length - 1)) {
        sOut += sBgn + sMd1 + sSpc.substring(3 * ((i % 16) + 1), sSpc.length()) + " - " + sEnd + "\n";

      }

    }
    return sOut;
  }
}