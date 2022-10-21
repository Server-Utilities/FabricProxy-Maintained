package tv.quaint;

import lombok.Getter;
import lombok.Setter;
import tv.quaint.objects.handling.derived.ModEventable;
import tv.quaint.storage.SelfConfig;

public class Manager extends ModEventable {
    @Getter
    static Manager instance;

    @Getter @Setter
    static SelfConfig selfConfig;

    public Manager() {
        super("FabricProxy-ReMaintained");
        instance = this;
        setSelfConfig(new SelfConfig());
    }
}
