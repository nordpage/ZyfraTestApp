package xyz.mobcoder.zyfra.arch.base;

public abstract class BaseContract {
    public interface  Presenter<T> {
        void attach(T view);
    }

    public interface View {
    }
}
