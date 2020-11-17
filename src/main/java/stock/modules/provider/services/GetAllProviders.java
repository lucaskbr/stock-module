package stock.modules.provider.services;


import stock.modules.provider.Provider;
import stock.modules.provider.ProviderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GetAllProviders {

    @Inject
    ProviderRepository providerRepository;

    public List<Provider> execute() {
        return providerRepository.list();
    }

}