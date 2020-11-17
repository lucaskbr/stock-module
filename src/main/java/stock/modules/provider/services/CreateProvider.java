package stock.modules.provider.services;


import stock.modules.provider.Provider;
import stock.modules.provider.ProviderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
@ApplicationScoped
public class CreateProvider {

    @Inject
    ProviderRepository providerRepository;

    public Provider execute(Provider provider) {
        return providerRepository.save(provider);
    }

}