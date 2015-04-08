/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tron;

/**
 *
 * @author xorsag2
 */
public enum Direction {

    UP {
        @Override
        public Direction opposite() {
            return Direction.DOWN;
        }

        @Override
        public Direction getRight() {
            return Direction.RIGHT;
        }

        @Override
        public Direction getLeft() {
            return Direction.LEFT;
        }

    }, RIGHT {
        @Override
        public Direction opposite() {
            return Direction.LEFT;
        }

        @Override
        public Direction getRight() {
            return Direction.DOWN;
        }

        @Override
        public Direction getLeft() {
            return Direction.UP;
        }
    }, DOWN {
        @Override
        public Direction opposite() {
            return Direction.UP;
        }

        @Override
        public Direction getRight() {
            return Direction.LEFT;
        }

        @Override
        public Direction getLeft() {
            return Direction.RIGHT;
        }
    }, LEFT {
        @Override
        public Direction opposite() {
            return Direction.RIGHT;
        }

        @Override
        public Direction getRight() {
            return Direction.UP;
        }

        @Override
        public Direction getLeft() {
            return Direction.DOWN;
        }
    };

    public abstract Direction opposite();

    public abstract Direction getRight();

    public abstract Direction getLeft();

    public static Direction tryChangeDirectionTo(Direction currentDirection, Direction newDirection) {
        return (newDirection == currentDirection.opposite()) ? currentDirection : newDirection;
    }
}
