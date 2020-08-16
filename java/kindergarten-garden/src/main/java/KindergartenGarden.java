import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class KindergartenGarden {
    private final String garden;

    KindergartenGarden(String garden) {
        this.garden = garden;
    }

    List<Plant> getPlantsOfStudent(String student) {
        final int index = 2 * (student.charAt(0) - 'A');
        return garden
                .lines()
                .flatMap(s -> Stream.of(Plant.getPlant(s.charAt(index)), Plant.getPlant(s.charAt(index + 1))))
                .collect(Collectors.toList());
    }

}
