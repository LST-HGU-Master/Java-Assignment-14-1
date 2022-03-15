# 課題 14-1: Runtime Exception

### 課題の説明
キーボードから入力した文字列とその文字数を印字するプログラムProgE1を作成した。
しかし、キーボードから期待以外の文字が入力されると実行時エラーが発生して異常終了してしまう。

まず、以下に示した3つの入力を実際に行い、それぞれの入力でどの命令が実行されるタイミングでどんな実行時エラー
が発生するかを確認する。

つぎに実行時エラーをtry-catch文を用いて例外処理するように修正しなさい。

### ProgE1.java
```java
public class ProgE1 {

    public static void main(String[] args) {
        String str = null; // String型変数strの宣言と初期化
        System.out.print("キーボードの確認：　1を押してエンターキーを押してください。:");
        int choice = new java.util.Scanner(System.in).nextInt();
        if(choice == "1") {
            str = "生命太郎";
        }
        System.out.println("文字列は「生命太郎」。文字数は"+str.length()+"です。");
    }
}
```

### 期待通りの入力
```
キーボードの確認：　1を押してエンターキーを押してください。:1
文字をタイプしてエンターキーを押してください。
生命太郎
入力は「生命太郎」。文字数は4です。
```

### 処理Aで例外が発生する入力例
```
キーボードの確認：　1を押してエンターキーを押してください。:2 
```

### 例外処理を行った実行例
```
キーボードの確認：　1を押してエンターキーを押してください。:2
エラーが生じたので処理を中断します。
エラーの内容を表示します。
java.lang.NullPointerException
	at ProgE1.main(ProgE1.java:12)
```


### Notes
- The JDK is installed on GitHub Actions machines, so you're also able to directly invoke `javac`, `java`, or any other CLI command included in the JDK. 
