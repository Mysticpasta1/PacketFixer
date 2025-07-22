package dev.tonimatas.packetfixer.mixins.v1_20_5_neoforge;

import dev.tonimatas.packetfixer.common.Config;
import net.neoforged.fml.loading.FMLLoader;
import org.apache.logging.log4j.LogManager;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String s) {
        if (isThisVersion()) {
            Config.runProperties();
            System.getProperties().setProperty("neoforge.disablePacketCompressionDebug", "true");
            LogManager.getLogger().info("Packet Fixer neoforge 1.20.5-1.21.X has been applied successfully.");
        }
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String s, String s1) {
        return isThisVersion();
    }
    
    private boolean isThisVersion() {
        String version = FMLLoader.versionInfo().mcVersion();
        return version.equals("1.20.5") || version.equals("1.20.6") || version.startsWith("1.21");
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }
}
