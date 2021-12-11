package info.vladyslav.javabasics.u01core.core_01_base.bs26_hex;

public class WorkWithHex {
    public static void main(String[] args) {
        char cc = (0x8 - 0x0 + 0x1) + (0xC - 0xB + 0x1) + (0x1F - 0xE + 0x1) + (0xffff - 0xfffe + 0x1);
        int i2 = cc - 0x1;
        int i3 = cc + 0x1;
        String hex = Integer.toHexString(cc);
        String hex2 = Integer.toHexString(i2);
        String hex3 = Integer.toHexString(i3);
        String in = "firs char --> " + cc + " || int --> " + (int) cc + " int2 --> " + i2 + " || hex --> " + hex + " hex previous --> " + hex2 + " || hex next --> " + hex3;

    }
}
