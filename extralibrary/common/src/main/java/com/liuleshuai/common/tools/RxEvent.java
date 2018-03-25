package com.liuleshuai.common.tools;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * RxJava2 设置监听器，监听event
 * Created by 67017 on 2018/3/25.
 */

public class RxEvent {
    /**
     * 相当于一个事件队列，存储的是Flowable事件
     */
    private FlowableProcessor<Object> eventQueue;

    /**
     * PublishSubject只会把在订阅发生的时间点之后来自原始Flowable的数据发射给观察者
     */
    public RxEvent() {
        eventQueue = PublishProcessor.create().toSerialized();
    }

    public static RxEvent getDefault() {
        return RxEventHolder.instance;
    }

    private static class RxEventHolder {
        private static RxEvent instance = new RxEvent();
    }

    /**
     * 添加一个新的事件
     *
     * @param o Object
     */
    public void post(Object o) {
        eventQueue.onNext(o);
    }

    /**
     * 过滤事件
     * 过滤操作符 ofType
     *
     * @param eventType 类型
     * @return Flowable<T>
     */
    public <T> Flowable<T> toFlowable(Class<T> eventType) {
        return eventQueue.ofType(eventType);
    }
}
