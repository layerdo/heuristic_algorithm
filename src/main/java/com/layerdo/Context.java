package com.layerdo;

public class Context {
    HeuristicAlgorithm strategy;

    public Context(HeuristicAlgorithm strategy) {
        this.strategy = strategy;
    }

    //上下文接口
    public void contextInterface() {
        strategy.algorithmInterface();
    }
}
