import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import Liphy from 'react-native-liphy';

export default function App() {
  const [result, setResult] = React.useState<string | undefined>();

  React.useEffect(() => {
    Liphy.startTracking();
    const removeListener = Liphy.addEventListener((data) => {
      console.log(data);
      setResult(data.lightId);
    });
    return () => {
      removeListener();
    };
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
