package com.aquari.quizitem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class QuizItem extends JavaPlugin implements Listener {

    Random random = new Random();
    Map<String, String> ScienceQuiz = new HashMap<>();
    Map<String, String> HistoryQuiz = new HashMap<>();
    Map<String, String> MathQuiz = new HashMap<>();

    public static int num = 0;

    String active = "";


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        getServer().broadcastMessage("クイズの内容をScienceQuiz/HistoryQuiz/MathQuizの中から選択してください");
        getServer().broadcastMessage("正解ならダイヤモンドを獲得できます");

        //科学クイズここから
        ScienceQuiz.put("原子番号が1の元素は何ですか？", "水素");
        ScienceQuiz.put("酸素と水素が結合してできる化合物は何ですか？", "水");
        ScienceQuiz.put("地球上で最も多く存在する気体は何ですか？", "地平線");
        ScienceQuiz.put("太陽系で最大の惑星は何ですか？", "木星");
        ScienceQuiz.put("植物が光合成に使用するエネルギー源は何ですか？", "太陽光");
        ScienceQuiz.put("氷は水のどの温度で融解しますか？", "0°C");
        ScienceQuiz.put("化学のpHスケールで、pH7は何を示しますか？", "中性");
        ScienceQuiz.put("酸素を取り入れ、エネルギーを生成する生命プロセスは何ですか？", "呼吸");
        ScienceQuiz.put("タンパク質、核酸、炭水化物、脂質の四大栄養素の中で、体にエネルギーを供給するのはどれですか？", "タンパク質");
        ScienceQuiz.put("一般的な水の化学式は何ですか？", "H2O");
        //ここまで

        //歴史クイズここから
        HistoryQuiz.put("フランス革命が始まった年は何年ですか？", "1789年");
        HistoryQuiz.put("アメリカ合衆国の独立宣言が採択された日は何日ですか？", "7月4日");
        HistoryQuiz.put("ナポレオン・ボナパルトはどの国の皇帝でしたか？", "フランス");
        HistoryQuiz.put("第一次世界大戦が始まった原因は何でしたか？", "サラエボ事件");
        HistoryQuiz.put("アメリカの南北戦争は何年から何年まで続きましたか？", "1861年から1865年");
        HistoryQuiz.put("マグナカルタは何の重要な歴史的文書ですか？", "王権制限宣言");
        HistoryQuiz.put("ローマ帝国が分裂した後、東部半分は何として知られましたか？", "東ローマ帝国");
        HistoryQuiz.put("マヤ文明の都市ティカルはどの国に位置していますか？", "グアテマラ");
        HistoryQuiz.put("ヒトラー率いるナチス党が台頭した国はどこですか？", "ドイツ");
        HistoryQuiz.put("マルティン・ルターはどの宗教改革の指導者でしたか？", "プロテスタント宗教改革");
        //ここまで

        //数学クイズここから
        MathQuiz.put("円の直径と半径の関係は何ですか？", " 直径は半径の2倍");
        MathQuiz.put("三角形の内角の合計は何度ですか？", " 180度");
        MathQuiz.put("2の累乗で表される最初の数は何ですか？", "2");
        MathQuiz.put("正方形の対角線の長さを求める公式は何ですか？", "辺の長さ × √2");
        MathQuiz.put("x^2 + y^2 = r^2 の方程式は何を表しますか？", "円");
        MathQuiz.put("45度の角度を弧度法で表すと何ですか？", "π/4 ラジアン");
        MathQuiz.put("12の最大公約数は何ですか？", "12");
        MathQuiz.put(" 3/4と6/8の最も簡単な共通分母は何ですか？", "8");
        MathQuiz.put("直線の傾きを求める公式は何ですか？", "(y2 - y1) / (x2 - x1)");
        MathQuiz.put("三角形の面積を求める公式で、底辺と高さを用いる公式は何ですか？", "(底辺 × 高さ) / 2");
        //ここまで
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage("クイズプラグインです。MathQuiz/HistoryQuiz/ScienceQuizのいずれかを入力してクイズに答えてください。正解でダイヤモンドが手に入ります");
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (event.getMessage().equals("ScienceQuiz")) {//科学クイズを選んだ場合
            num = random.nextInt(10);
            List<String> list = new ArrayList<>(ScienceQuiz.keySet());

            String Question = list.get(num);
            player.sendMessage(Question);
            active = "Science";
        } else if (event.getMessage().equals("HistoryQuiz")) {//歴史クイズを選んだ場合
            num = random.nextInt(10);
            List<String> list = new ArrayList<>(HistoryQuiz.keySet());

            String Question = list.get(num);
            player.sendMessage(Question);
            active = "History";
        } else if (event.getMessage().equals("MathQuiz")) {//数学クイズを選んだ場合
            num = random.nextInt(10);
            List<String> list = new ArrayList<>(MathQuiz.keySet());

            String Question = list.get(num);
            player.sendMessage(Question);
            active = "Math";
        }

    }

    @EventHandler
    public void onAnswer(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (active.equals("Science")) {
            List<String> list2 = new ArrayList<>(ScienceQuiz.values());
            String QuestionAnswer = list2.get(num);
            if (event.getMessage().equals(QuestionAnswer)) {
                player.sendMessage("正解です");
                player.getInventory().addItem(new ItemStack(Material.DIAMOND));
                player.sendMessage("ダイヤモンドを獲得しました");
                active = "";
            } else {
                player.sendMessage("不正解です");
                active = "";
            }
        } else if (active.equals("History")) {
            List<String> list2 = new ArrayList<>(HistoryQuiz.values());
            String QuestionAnswer = list2.get(num);
            if (event.getMessage().equals(QuestionAnswer)) {
                player.sendMessage("正解です");
                player.getInventory().addItem(new ItemStack(Material.DIAMOND));
                player.sendMessage("ダイヤモンドを獲得しました");
                active = "";
            } else {
                player.sendMessage("不正解です");
                active = "";
            }
        } else if (active.equals("Math")) {
            List<String> list2 = new ArrayList<>(MathQuiz.values());
            String QuestionAnswer = list2.get(num);
            if (event.getMessage().equals(QuestionAnswer)) {
                player.sendMessage("正解です");
                player.getInventory().addItem(new ItemStack(Material.DIAMOND));
                player.sendMessage("ダイヤモンドを獲得しました");
                active = "";
            } else {
                player.sendMessage("不正解です");
                active = "";
            }
        }
    }
}
