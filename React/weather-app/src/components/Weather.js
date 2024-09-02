import React, { useEffect, useState, useContext } from "react";
import {
  Container,
  SimpleGrid,
  Heading,
  Text,
  Card,
  CardHeader,
  CardBody,
  CardFooter,
  Image,
  Box,
} from "@chakra-ui/react";
import axios from "axios";
import CityContext from "../context/CityContext";

function Weather() {
  const [weatherData, setWeatherData] = useState(null);
  const { city } = useContext(CityContext);

  useEffect(() => {
    const fetchData = async () => {
      console.log("fetchData çalıştırılıyor...");
      try {
        const response = await axios.get(
          `http://api.weatherapi.com/v1/forecast.json?key=0c751ea427ba4b3497880506242808&q=${city}&days=7&aqi=yes&alerts=yes`
        );
        // Veri yapısını kontrol edin
        console.log(response.data);

        setWeatherData(response.data.forecast.forecastday);
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, [city]);

  const getDayName = (event) => {
    const date = new Date(event);
    return date.toLocaleDateString("tr-TR", { weekday: "long" });
  };

  const today = new Date().toISOString().split("T")[0];

  return (
    <Container>
      <SimpleGrid
        spacing={4}
        templateColumns="repeat(auto-fill, minmax(140px, 1fr))"
      >
        {weatherData ? (
          weatherData.map((event) => (
            <Card
              key={event.date}
              borderWidth={event.date === today ? "2px" : "1px"}
              borderColor={event.date === today ? "gray.500" : "gray.200"}
              borderRadius="md"
              p={4}
            >
              <CardHeader>
                <Heading size="md">{getDayName(event.date)}</Heading>
              </CardHeader>
              <CardBody>
                <Box>
                  <Image
                    src={`http:${event.day.condition.icon}`}
                    alt={event.day.condition.text}
                  />
                </Box>
                <Text>{event.day.condition.text}</Text>
              </CardBody>
              <CardFooter>
                <Text>
                  {`Max Temp : ${event.day.maxtemp_c}`}
                  <br />
                  {`Min Temp :  ${event.day.mintemp_c}`}
                </Text>
              </CardFooter>
            </Card>
          ))
        ) : (
          <Text>Yükleniyor...</Text>
        )}
      </SimpleGrid>
    </Container>
  );
}

export default Weather;
