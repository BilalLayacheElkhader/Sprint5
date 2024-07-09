package cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class dtoFlor implements Serializable {
    private int pk_FlorID;
    private String nameFlor;
    private String countryFlor;
    private String typeBranch;

    private static final List<String> euCountries = new ArrayList<>(Arrays.asList("portugal","spain","france",
            "austria","germany","italy","greece", "belgium", "bulgaria", "croatia", "republic of cyprus",
            "czech republic", "denmark", "estonia", "finland", "hungary", "ireland", "latvia", "lithuania",
            "luxembourg", "malta", "netherlands", "poland", "romania", "slovakia", "slovenia", "sweden"));

    public dtoFlor(String nameFlor, String countryBranch) {
        this.nameFlor = nameFlor;
        this.countryFlor = countryBranch;
        this.typeBranch = countryBranch != null && euCountries.contains(countryBranch.toLowerCase()) ? "EU" : "NOT EU";
    }
}
