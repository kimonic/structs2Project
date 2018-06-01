package S_18_1.s_2_5;

import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.SchedulingConfiguration;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({SchedulingConfiguration.class})
@Documented
public @interface EnableScheduling {
}
/**
 @Target({java.lang.annotation.ElementType.TYPE})
 @Retention(RetentionPolicy.RUNTIME)
 @Import({SchedulingConfiguration.class})
 @Documented
 public @interface EnableScheduling
 {
 }*/