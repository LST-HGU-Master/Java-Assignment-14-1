# 課題 14-1: Runtime Exception（実行時エラー対策）

### 課題の説明
キーボードから数字の1を入力するとコード中で指定した文字列「生命太郎」とその文字数を印字するプログラムProgE1を作成した。
しかし、キーボードから1以外の文字が入力されると実行時エラーが発生して異常終了してしまう。

まず、以下に示した3つの入力を実際に行い、それぞれの入力でどの命令が実行されるタイミングでどんな実行時エラー
が発生するかを確認しなさい。

つぎに実行時エラーをtry-catch文を用いて例外処理するように修正しなさい。

### ProgE1.java（修正前）
```java
public class ProgE1 {

    public static void main(String[] args) {
        String str = null; // String型変数strの宣言と初期化
        System.out.print("キーボードの確認：　1を押してエンターキーを押してください。:");
        int choice = new java.util.Scanner(System.in).nextInt();
        if(choice == 1) {
            str = "生命太郎";
        }
        System.out.println("文字列は「生命太郎」。文字数は"+str.length()+"です。");
    }
}
```

### 期待通りの入力での出力
```
キーボードの確認：　1を押してエンターキーを押してください。:1
文字列は「生命太郎」。文字数は4です。
```

### 例外が発生する入力の実行例(1)
```
キーボードの確認：　1を押してエンターキーを押してください。:2
    Exception occurred.
---下側のペイン---
java.lang.NullPointerException
	at ProgE1.main(ProgE1.java:18)　

```

### 例外が発生する入力の実行例(2) -- 英小文字のq
```
キーボードの確認：　1を押してエンターキーを押してください。:q
    Exception occurred.
---下側のペイン---
java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
	at java.base/java.util.Scanner.next(Scanner.java:1594)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
	at ProgE1.main(ProgE1.java:14)　
```


### 例外処理を行った実行例(1)
```
キーボードの確認：　1を押してエンターキーを押してください。:2
エラーが生じたので処理を中断します。
エラーの内容を表示します。
---下側のペイン---
java.lang.NullPointerException
	at ProgE1.main(ProgE1.java:18)
	at __SHELL4.run(__SHELL4.java:6)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at bluej.runtime.ExecServer$3.lambda$run$0(ExecServer.java:850)
	at bluej.runtime.ExecServer.runOnTargetThread(ExecServer.java:973)
	at bluej.runtime.ExecServer$3.run(ExecServer.java:847)

```

### 例外処理を行った実行例(2)
```
キーボードの確認：　1を押してエンターキーを押してください。:q
エラーが生じたので処理を中断します。
エラーの内容を表示します。
---下側のペイン---
java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
	at java.base/java.util.Scanner.next(Scanner.java:1594)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
	at ProgE1.main(ProgE1.java:14)
	at __SHELL5.run(__SHELL5.java:6)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at bluej.runtime.ExecServer$3.lambda$run$0(ExecServer.java:850)
	at bluej.runtime.ExecServer.runOnTargetThread(ExecServer.java:973)
	at bluej.runtime.ExecServer$3.run(ExecServer.java:847)

```
（注）BlueJでは、Java.lang.NullPointerException などのエラーメッセージは下半分のペインに表示されます。
　　　ProgE1.java：## に表示されるコードの行番号はコメント行の有無で変わります。

