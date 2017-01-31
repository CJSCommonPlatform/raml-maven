package uk.gov.justice.raml.maven.lintchecker.rules;

import uk.gov.justice.raml.maven.lintchecker.LintCheckRule;
import uk.gov.justice.raml.maven.lintchecker.LintCheckerException;

import org.raml.model.Raml;

public class FailingLintCheckRule implements LintCheckRule {

    @Override
    public void execute(final Raml raml) throws LintCheckerException {
        throw new LintCheckerException("LintCheckRule applied");
    }
}
