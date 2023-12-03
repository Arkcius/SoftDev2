package unit04.connectfour.model;

/**
 * Possible moves in a game of Connect Four.
 */
public enum Checker {
    NONE,
    RED{
        @Override
        public String toString() {
        return "Red";
        }},
    BLACK{
        @Override
        public String toString() {
        return "Yellow";
        }};
}
