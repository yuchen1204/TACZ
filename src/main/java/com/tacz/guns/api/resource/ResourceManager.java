package com.tacz.guns.api.resource;

import org.apache.commons.compress.utils.Lists;

import java.nio.file.Paths;
import java.util.List;

/**
 * 用于注册需要解压释放的枪包，为其他附属模组使用
 */
public final class ResourceManager {
    /**
     * 存放所有待解压枪包路径
     */
    public static final List<ExtraEntry> EXTRA_ENTRIES = Lists.newArrayList();

    /**
     * 注册待解压枪包
     *
     * @param modMainClass    附属模组的主类
     * @param extraFolderPath 需要解压的文件夹，比如 TACZ 自己就是 /assets/tacz/custom/tacz_default_gun <br>
     *                        这表示把 tacz_default_gun 文件夹解压出来，放置到枪械包安装目录下
     */
    public static void registerExtraGunPack(Class<?> modMainClass, String extraFolderPath) {
        EXTRA_ENTRIES.add(new ExtraEntry(modMainClass, extraFolderPath, Paths.get(extraFolderPath).getFileName().toString()));
    }

    /**
     * 解压条目
     */
    public record ExtraEntry(Class<?> modMainClass, String srcPath, String extraDirName) {
    }
}
