package com.example.kafka.operation;

public interface IOperation<T> {

    void handle(T consumerRequest);

}
