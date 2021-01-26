package syx.entity;

import lombok.Data;

/**
 * * 父级密闭类
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/11 15:09
 */
@Data
public sealed class ClassSealedBase permits ClassSealedA, ClassSealedB {

    // sealed--防止继承滥用
    // permits--许可，类似通行证，许可证一类；指定允许继承的类,一旦指定，必须继承
    private String id;

    private String name;

}
