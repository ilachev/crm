package ru.restoclub.crm.config.apidoc;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import io.github.jhipster.config.apidoc.customizer.SwaggerCustomizer;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

@Component
public class SwaggerSecurityCustomizer implements SwaggerCustomizer {

    private static final String[] PUBLIC_ENDPOINTS = {
        "/api/account/change-password",
        "/api/account/reset-password/finish",
        "/api/account/reset-password/init",
        "/api/activate",
        "/api/authenticate",
        "/api/register"
    };

    @Override
    public void customize(Docket docket) {
        docket
            .securitySchemes(newArrayList(bearerScheme()))
            .securityContexts(newArrayList(new SecurityContext(bearerAuth(), not(PUBLIC_ENDPOINTS))));
    }


    @SuppressWarnings("unchecked")
    private Predicate<String> not(String... paths) {
        Predicate[] regexPredicates = Stream.of(paths)
            .map(PathSelectors::regex)
            .toArray(Predicate[]::new);

        Predicate publicPathsRegex = Predicates.or(regexPredicates);
        return Predicates.not(publicPathsRegex);
    }

    /**
     * Bearer security scheme of the entire json spec file
     *
     * @return a Security Scheme
     */
    private SecurityScheme bearerScheme() {
        return new ApiKey("Bearer", "Authorization", "header");
    }

    /**
     * Builds a list with a unique Bearer security context
     * security:
     * - Bearer: []
     *
     * @return a singleton list with one Bearer security reference
     */
    private List<SecurityReference> bearerAuth() {
        return Collections.singletonList(new SecurityReference("Bearer", new AuthorizationScope[0]));
    }

}
