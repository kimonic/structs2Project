package S_18_1.s_2_3;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getEnvironment().getProperty("os.name").contains("Windows");
    }
}

/**
 * import org.springframework.context.annotation.Condition;
 * import org.springframework.context.annotation.ConditionContext;
 * import org.springframework.core.type.AnnotatedTypeMetadata;
 *
 * public class WindowsCondition implements Condition {
 *
 *     public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata) {
 *         return context.getEnvironment().getProperty("os.name").contains("Windows");
 *     }
 * }
 */
