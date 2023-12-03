package unit03.thegame;

public class TheGame{
    public static void main(String[] args){
        Deck deck = new Deck();
        Human player = new Human(new Hand(7));
        AscendingPile ap1 = new AscendingPile(1);
        AscendingPile ap2 = new AscendingPile(1);
        DescendingPile dp1 = new DescendingPile(100);
        DescendingPile dp2 = new DescendingPile(100);
        DiscardPile[] discards = {ap1,dp1,dp2,ap2};
        Table table = new Table(discards, deck);
        boolean gameOver =false;
        int turn = 0;
        int cardsPlayed = 0;
        for(int i = 0; i<5;i++){
            player.deal(deck.drawCard());
        }
        while(gameOver==false){
            player.deal(deck.drawCard());
            System.out.println(table);
            System.out.println(player);
            MoveType cur = player.nextMove();
            while(cur!=MoveType.PASS){
                DiscardMove dis = player.discard();
                boolean works = discards[dis.getPileNumber()].discard(dis.getCard());
                if(works == true){
                    System.out.println("nice move");
                    cardsPlayed++;
                }
                else{
                    System.out.println("didnt work");
                    player.deal(dis.getCard());
                }
                cur = player.nextMove();
            }
            if(cur==MoveType.PASS){
                if(cardsPlayed<=2){
                    gameOver = player.confirmGameOver();
                }
            }
            turn++;
            System.out.println("Turn "+turn);
            if(deck.remainingCardCount()==0 && player.handIsEmpty()==true){
                gameOver = true;
            }
            }
        }
        
    }

