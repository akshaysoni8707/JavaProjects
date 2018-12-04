import java.util.Random;

public class Player implements Runnable {
    private static int totalMatches = 0;
    private boolean alive = true;
    private Player player = null, player_1 = null, player_2 = null;
    private int id;
    private String name;
    private int life = 100;
    private boolean fightMode = false, gameplay = true;
    private Player player1[] = new Player[100], player2[] = new Player[100], gameObject;
    private Random random = new Random();
    private String message;

    Player() {
    }

    private Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Player a = new Player();
        long start, end;
        start = System.currentTimeMillis();
        a.game();
        do {
            a.run();
        } while (!a.win());
        end = System.currentTimeMillis();
        System.out.println("time : " + (end - start));
    }

    void setGameObject(Player gameObject) {
        this.gameObject = gameObject;
    }

    boolean getGameStatus() {
        return gameObject.gameplay;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", life=" + life +
                ", alive=" + alive +
                ", fightMode=" + fightMode +
                '}';
    }

    void game() {
        for (int i = 0; i < player1.length; i++) {
            player1[i] = new Player(i + 1, "Player 1-" + (i + 1));
            player2[i] = new Player(i + 1, "Player 2-" + (i + 1));
        }
    }

    void display() {
        try {
            Thread.sleep(1000);
            System.out.println("\n" + message + "\n");
            for (int i = 0; i < player1.length; i++) {
                System.out.println(player1[i].toString() + " ---- " + player2[i].toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(totalMatches);
    }

    private boolean win() {
        int countA = 0, countB = 0;
        for (int i = 0; i < player2.length; i++) {
            if (!player1[i].alive) {
                countA++;
            }
            if (!player2[i].alive) {
                countB++;
            }
        }
        if (countA == player2.length) {
            message = "player 2 wins";
            return true;
        } else if (countB == player2.length) {
            message = "player 1 wins";
            return true;
        } else {
            return false;
        }
    }

    private int healing(Player p) {
        int newlife = 0;
        if (p.life < 20) {
            newlife = p.life + random.nextInt(60);
        } else if (p.life < 40) {
            newlife = p.life + random.nextInt(40);
        } else if (p.life < 60) {
            newlife = p.life + random.nextInt(20);
        } else if (p.life < 75) {
            newlife = p.life + random.nextInt(5);
        } else {
            newlife = p.life;
        }
        return newlife;
    }

    private void checking(Player p[]) {
        if (p[0].name.contains("Player 1-")) {
            if (Thread.currentThread().getId() % 2 == 0) {
                for (int i = 0; i < p.length; i++) {
                    if (p[i].alive && !p[i].fightMode) {
                        player_1 = p[i];
                        break;
                    }
                    if (i == p.length - 1) {
                        player_1 = player;
                        break;
                    }
                }
            } else {
                for (int i = p.length - 1; i >= 0; i--) {
                    if (p[i].alive && !p[i].fightMode) {
                        player_1 = p[i];
                        break;
                    }
                    if (i == 0) {
                        player_1 = player;
                        break;
                    }
                }
            }


        } else if (p[0].name.contains("Player 2-")) {
            if (Thread.currentThread().getId() % 2 == 0) {
                for (int i = 0; i < p.length; i++) {
                    if (p[i].alive && !p[i].fightMode) {
                        player_2 = p[i];
                        break;
                    }
                    if (i == p.length - 1) {
                        player_2 = player;
                        break;
                    }
                }
            } else {
                for (int i = p.length - 1; i >= 0; i--) {
                    if (p[i].alive && !p[i].fightMode) {
                        player_2 = p[i];
                        break;
                    }
                    if (i == 0) {
                        player_2 = player;
                        break;
                    }
                }
            }
        }
    }

    private void updateFightStatus(Player p[], Player p1, boolean alivestatus, boolean fight) {
        for (int i = 0; i < p.length; i++) {
            if (p[i].name.equalsIgnoreCase(p1.name) && p[i].name.contains("Player 1-")) {
                if (alivestatus && !fight) {
                    player1[i].life = healing(player1[i]);
                }
                player1[i].fightMode = fight;
                player1[i].alive = alivestatus;
                break;
            } else if (p[i].name.equalsIgnoreCase(p1.name) && p[i].name.contains("Player 2-")) {
                if (alivestatus && !fight) {
                    player2[i].life = healing(player2[i]);
                }
                player2[i].fightMode = fight;
                player2[i].alive = alivestatus;
                break;
            }
        }
    }

    @Override
    public void run() {
        Player p2, p1;
        try {
            if (!win()) {
                checking(player1);
                Thread.sleep(50);
                p1 = player_1;
                checking(player2);
                Thread.sleep(50);
                p2 = player_2;
                if (p1 != null && p2 != null && p1.alive && p2.alive && !(p1.fightMode) && !(p2.fightMode)) {
                    updateFightStatus(player1, p1, true, true);
                    updateFightStatus(player2, p2, true, true);
                    fight(p1, p2);
                    Thread.sleep(50);
                }
            } else {
                gameObject.gameplay = false;
                Thread.currentThread().interrupt();
            }
        } catch (Exception e) {
            System.out.println("Player not found : " + e.getMessage());
        }
    }

    private void fight(Player p1, Player p2) {
        try {
            do {
                int attack1 = randomGenerator(), attack2 = randomGenerator();
                if (attack1 < attack2) {
                    p1.life = p1.life - (attack2 - attack1);
                } else if (attack1 > attack2) {
                    p2.life = p2.life - (attack1 - attack2);
                }
                if (p1.life <= 0 && p2.life > 0) {
                    try {
                        System.out.println(p1.name + " vs " + p2.name + "\n" +
                                "winner " + p2.name + " " + p2.life);
                        updateFightStatus(player1, p1, false, false);
                        updateFightStatus(player2, p2, true, false);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    totalMatches++;
                    break;
                } else if (p2.life <= 0 && p1.life > 0) {
                    try {
                        System.out.println(p1.name + " vs " + p2.name + "\n" +
                                "winner " + p1.name + " " + p1.life);
                        updateFightStatus(player1, p1, true, false);
                        updateFightStatus(player2, p2, false, false);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    totalMatches++;
                    break;
                }
            } while ((p1.life > 0) || (p2.life > 0));
        } catch (Exception e) {
            System.out.println("Fight Error : " + e.getMessage());
        }
    }

    private int randomGenerator() {
        int randomData = 0;
        try {
            randomData = random.nextInt(15);
            Thread.sleep(10);
        } catch (Exception e) {
            System.out.println("Random ERR : " + e.getMessage());
        }
        return randomData;
    }
}

