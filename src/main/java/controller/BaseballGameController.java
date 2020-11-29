package controller;

import baseball.BaseballGame;
import domain.BaseballNumber;
import domain.Hint;
import domain.Player;
import java.util.List;
import java.util.Scanner;
import utils.RandomNumbers;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class BaseballGameController {
    private static final int RANDOM_NUMBERS_SIZE = 3;

    private final Scanner scanner;
    private Player player;
    private BaseballGame baseballGame;

    public BaseballGameController(final Scanner scanner) {
        this.scanner = scanner;
        this.baseballGame = new BaseballGame(new BaseballNumber(nonDuplicateNumber()));
        this.player = new Player();
    }

    private List<Integer> nonDuplicateNumber() {
        return RandomNumbers.getInstance(RANDOM_NUMBERS_SIZE);
    }

    public void play() {
        BaseballNumber playerBaseballNumber = player.createBaseballNumber(getInput());
        baseballGame.exists(playerBaseballNumber);
        Hint hint = baseballGame.countStrikeAndBall(playerBaseballNumber);
        System.out.println(hint);
    }

    private String getInput() {
        return scanner.nextLine();
    }
}
