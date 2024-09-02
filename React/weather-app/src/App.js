import "./App.css";
import { CityProvider } from "./context/CityContext";
import Container from "./components/Container";
import { ChakraProvider } from "@chakra-ui/react";
import { LocationProvider } from "./context/LocationContext";

function App() {
  return (
    <ChakraProvider>
      <div className="App">
        <LocationProvider>
          <CityProvider>
            <Container></Container>
          </CityProvider>
        </LocationProvider>
      </div>
    </ChakraProvider>
  );
}

export default App;
