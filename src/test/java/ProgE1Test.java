import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
/**
 * @version (20220625)
 */
public class ProgE1Test {
    InputStream originalIn;
    PrintStream originalOut;
    PrintStream originalErr;
    ByteArrayOutputStream bos;
    StandardInputStream in;
    
    @BeforeEach
    void before() {
        //back up binding
        originalIn  = System.in;
        originalOut = System.out;
        originalErr = System.err;
        
        bos = new ByteArrayOutputStream();
        
        //modify binding
        in = new StandardInputStream();
        System.setIn(in);
    }
    
    @AfterEach
    void after() {
       System.setOut(originalOut);
       System.setIn(originalIn);
       System.setErr(originalErr);
    }

    @Test
    public void testNoError()
    {
        //modify binding
        System.setOut(new PrintStream(bos));
        // action
        in.inputln("1"); // 標準入力をテストする場合
        ProgE1.main(null);
        // undo the binding in System
        after(); // redundant?
        
        // assertion
        String[] print = bos.toString().split("\r\n|\n");
        assertTrue(print[print.length - 1].contains("文字列は「生命太郎」。文字数は4です。"),"期待通りの入力での出力が不正です!");
    }

    @Test
    public void testStdOutWithError()
    {
        //modify binding
        System.setOut(new PrintStream(bos));
        System.setErr(new PrintStream(new ByteArrayOutputStream()));

        // action
        in.inputln("2");
        ProgE1.main(null);
        // undo the binding in System
        after(); // redundant?
        
        // assertion
        //String[] print = bos.toString().split("\r\n|\n");
        assertTrue(bos.toString().contains("エラーが生じたので処理を中断します"),"例外処理を行った際に「エラーが生じたので処理を中断します」の表示がありません!");
        assertTrue(bos.toString().contains("エラーの内容を表示します"),"例外処理を行った際に「エラーの内容を表示します」の表示がありません!");
    }
    
    @Test
    public void testStdErrWithError1()
    {
       //modify binding
       System.setOut(new PrintStream(new ByteArrayOutputStream()));
       System.setErr(new PrintStream(bos));

       // action
       in.inputln("2");
       ProgE1.main(null);
       // undo the binding in System
       after(); // redundant?

       // assertion
       //String[] print = bos.toString().split("\r\n|\n");
       assertTrue(bos.toString().contains("java.lang.NullPointerException"),"例外処理を行った際のエラー表示「java.lang.NullPointerException」がありません!");
       assertTrue(bos.toString().contains("ProgE1.main"),"例外処理を行った際のエラー表示が指示と異なります!（教員に相談してください）");
    }
    
    @Test
    public void testStdErrWithError2()
    {
       System.setOut(new PrintStream(new ByteArrayOutputStream()));
       System.setErr(new PrintStream(bos));

       // action
       in.inputln("Z");
       ProgE1.main(null);
       // undo the binding in System
       after(); // redundant?

       // assertion
       //String[] print = bos.toString().split("\r\n|\n");
       assertTrue(bos.toString().contains("java.util.InputMismatchException"),"例外処理を行った際のエラー表示「java.util.InputMismatchException」がありません!");
       assertTrue(bos.toString().contains("ProgE1.main"),"例外処理を行った際のエラー表示が指示と異なります!（教員に相談してください）");
    }
}
