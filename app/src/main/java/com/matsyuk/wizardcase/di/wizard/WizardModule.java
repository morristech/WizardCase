package com.matsyuk.wizardcase.di.wizard;

import com.matsyuk.wizardcase.business.license.LicenseInteractor;
import com.matsyuk.wizardcase.business.license.LicenseInteractorFake;
import com.matsyuk.wizardcase.presentation.activation.wizard_part.ActivationWizardPart;
import com.matsyuk.wizardcase.presentation.info.wizard_part.InfoWizardPart;
import com.matsyuk.wizardcase.presentation.license.wizard_part.LicenseWizardPart;
import com.matsyuk.wizardcase.wizards.WizardSmartRouter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

import static com.matsyuk.wizardcase.di.DiConstants.INFO_FINISH_ANNOTATION;
import static com.matsyuk.wizardcase.di.DiConstants.INFO_START_ANNOTATION;

/**
 * @author e.matsyuk
 */
@Module
public class WizardModule {

    /**
     * Smart router
     */

    @WizardScope
    @Provides
    WizardSmartRouter provideStartWizardManager(Router router) {
        return new WizardSmartRouter(router);
    }

    /**
     * Interactors
     */

    @WizardScope
    @Provides
    LicenseInteractor provideFirstWizardInteractor() {
        return new LicenseInteractorFake();
    }

    /**
     * Wizard parts
     */

    @WizardScope
    @Provides
    @Named(INFO_START_ANNOTATION)
    InfoWizardPart provideInfoStartWizardPartStart(WizardSmartRouter wizardSmartRouter) {
        return wizardSmartRouter.getInfoStartWizardPart();
    }

    @WizardScope
    @Provides
    LicenseWizardPart provideLicenseWizardPart(WizardSmartRouter wizardSmartRouter) {
        return wizardSmartRouter.getLicenseWizardPart();
    }

    @WizardScope
    @Provides
    ActivationWizardPart provideActivationWizardPart(WizardSmartRouter wizardSmartRouter) {
        return wizardSmartRouter.getActivationWizardPart();
    }

    @WizardScope
    @Provides
    @Named(INFO_FINISH_ANNOTATION)
    InfoWizardPart provideInfoFinishWizardPartStart(WizardSmartRouter wizardSmartRouter) {
        return wizardSmartRouter.getInfoFinishWizardPart();
    }

}