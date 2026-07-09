// # LeetCode 1025: Divisor Game

// ## Problem Description
// Alice and Bob take turns playing a game, with Alice starting first. Initially, there is a number `n` on the chalkboard. On each player's turn, that player makes a move consisting of:
// * Choosing any `x` with `0 < x < n` and `n % x == 0`.
// * Replacing the number `n` on the chalkboard with `n - x`.

// If a player cannot make a move, they lose the game. Return `true` if and only if Alice wins the game, assuming both players play optimally.

// ## Solution (Java)

class Solution {
    public boolean divisorGame(int n) {
        // Alice wins if and only if n is even
        return n % 2 == 0;
    }
}