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
