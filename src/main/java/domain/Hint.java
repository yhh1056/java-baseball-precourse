package domain;

import static domain.Message.BALL;
import static domain.Message.BLANK;
import static domain.Message.STRIKE;

/**
 * @author yhh1056
 * @since 2020/11/28
 */
public class Hint {
    private static final int NO_COUNT = 0;

    private int strikeCount = 0;
    private int ballCount = 0;

    public void countStrike() {
        strikeCount++;
    }

    public void countBall() {
        ballCount++;
    }

    @Override
    public String toString() {
        if (strikeCount == NO_COUNT) {
            return ballCount();
        }
        if (ballCount == NO_COUNT) {
            return strikeCount();
        }
        return ballAndStrikeCount();
    }

    private String ballCount() {
        return new StringBuilder()
            .append(ballCount).append(BALL)
            .toString();
    }

    private String strikeCount() {
        return new StringBuilder()
            .append(strikeCount).append(STRIKE)
            .toString();
    }

    private String ballAndStrikeCount() {
        return new StringBuilder()
            .append(ballCount).append(BALL)
            .append(BLANK)
            .append(strikeCount).append(STRIKE)
            .toString();
    }
}
