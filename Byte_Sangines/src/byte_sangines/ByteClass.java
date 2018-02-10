package byte_sangines;

public class ByteClass {

    private char[] byt;

    public ByteClass() {
        byt = new char[8];
    }

    public ByteClass(ByteClass b) {
        this.byt = b.byt;
    }

    public ByteClass(char[] bit) {
        this.byt = bit;
    }

    public ByteClass add(ByteClass a) {
        char[] sum = new char[8];
        char[] byte1 = new char[8];
        char[] byte2 = new char[8];
        char carry = '0';
        for (int i = 0; i < 8; i++) {
            byte1[i] = this.byt[i];
            byte2[i] = a.byt[i];

        }

        for (int i = 7; i >= 0; i--) {
            if (byte1[i] == '0' && byte2[i] == '0' && carry == '0') {
                sum[i] = '0';
                carry = '0';
            } else if (byte1[i] == '0' && byte2[i] == '0' && carry == '1') {
                sum[i] = '1';
                carry = '0';
            } else if (byte1[i] == '0' && byte2[i] == '1' && carry == '0') {
                sum[i] = '1';
                carry = '0';
            } else if (byte1[i] == '1' && byte2[i] == '0' && carry == '0') {
                sum[i] = '1';
                carry = '0';
            } else if (byte1[i] == '1' && byte2[i] == '1' && carry == '1') {
                sum[i] = '1';
                carry = '1';
            } else if (byte1[i] == '0' && byte2[i] == '1' && carry == '1') {
                sum[i] = '0';
                carry = '1';
            } else if (byte1[i] == '1' && byte2[i] == '1' && carry == '0') {
                sum[i] = '0';
                carry = '1';
            } else if (byte1[i] == '1' && byte2[i] == '0' && carry == '1') {
                sum[i] = '0';
                carry = '1';
            }
        }
        return new ByteClass(sum);
    }

    public ByteClass to2sComplement() {
        int count = 7;//to find where the first 1 is and change it to 0

        while (this.byt[count] == '0') {
            count--;
        }//once we know where it is, we have to take the next number(--i) before we use it
        --count;
        while (count >= 0) {
            if (byt[count] == '1') {
                byt[count] = '0';
            } else if (byt[count] == '0') {
                byt[count] = '1';
            }
            --count;

        }
        return new ByteClass(byt);
    }

    public ByteClass biasTo2sComplement() {
        if (byt[0] == '1') {
            byt[0] = '0';
        } else if (byt[0] == '0') {
            byt[0] = '1';
        }

        return new ByteClass(byt);
    }

    public int magnitude() {
        int valor = 0;
        int exp = 0;
        for (int i = 7; i >= 0; i--) {
            if (byt[i] == '1') {
                valor = (int) Math.pow(2, exp);
                valor += valor;
            }
            exp++;
        }
        return valor;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < byt.length; i++) {
            r.append(byt[i]);

        }
        return r.toString();
    }

}
