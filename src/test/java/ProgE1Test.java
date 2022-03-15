import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProgE1Test {

    @Test
    public void testNoError()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        in.inputln("1"); // 標準入力をテストする場合
        ProgE1.main(null);

        // assertion
        String[] print = bos.toString().split("\n");
        assertTrue(print[print.length - 1].contains("文字列は「生命太郎」。文字数は4です。"));

        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    public void testError()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        in.inputln("2");
        ProgE1.main(null);

        // assertion
        String[] print = bos.toString().split("\n");
        assertTrue(bos.toString().contains("エラーが生じたので処理を中断します"));

        // undo the binding in System
        System.setOut(originalOut);
    }
}
