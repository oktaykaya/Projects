import React, { useContext, useEffect, useState } from "react";
import { Select, Container, SimpleGrid } from "@chakra-ui/react";
import CityContext from "../context/CityContext";
import LocationContext from "../context/LocationContext";

function City() {
  const { setCity, cities } = useContext(CityContext);
  const location = useContext(LocationContext);
  const [selectedCity, setSelectedCity] = useState("");
  const [nearestCity, setNearestCity] = useState(null);

  // Konuma göre en yakın şehri bulur ve state'e kaydeder
  useEffect(() => {
    if (location && location.latitude != null && location.longitude != null) {
      const findNearestCity = () => {
        let closestCity = null;
        let minDistance = Infinity;

        cities.forEach((city) => {
          if (city.latitude != null && city.longitude != null) {
            const distance = Math.sqrt(
              Math.pow(city.latitude - location.latitude, 2) +
                Math.pow(city.longitude - location.longitude, 2)
            );
            if (distance < minDistance) {
              closestCity = city;
              minDistance = distance;
            }
          }
        });

        setNearestCity(closestCity);
      };
      findNearestCity();
    }
  }, [location, cities]);

  // Bileşen ilk kez render edildiğinde en yakın şehri seçili olarak ayarlar
  useEffect(() => {
    if (nearestCity && selectedCity === "") {
      setSelectedCity(nearestCity.name);
      setCity(nearestCity.name);
    }
  }, [nearestCity, selectedCity, setCity]);

  const selectCity = (event) => {
    const newCity = event.target.value;
    setSelectedCity(newCity);
    setCity(newCity);
  };

  return (
    <div>
      <Container>
        <SimpleGrid
          spacing={4}
          templateColumns="repeat(auto-fill, minmax(140px, 1fr))"
        ></SimpleGrid>
        <Select
          onChange={selectCity}
          value={selectedCity}
          placeholder={"Şehir Seçin"}
        >
          {cities.map((city) => (
            <option key={city.name} value={city.name}>
              {city.name}
            </option>
          ))}
        </Select>
      </Container>
    </div>
  );
}

export default City;
