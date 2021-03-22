# react-native-liphy

React Native Wrapper for LiPHY SDK

## Installation

```sh
yarn add react-native-liphy
```

#### iOS

1. Put `LightFlySDK` to `ios/` of your react native projcet and add below line to the bottom of `ios/Podfile`

```
pod 'LightFlySDK', :path => './LightFlySDK'
```

2. Run `npx pod-install`

3. Add `Privacy - Camera Usage Description` to `Info.plist`

#### Android

1.

2.

3.

## Usage

```js
import Liphy from "react-native-liphy";

// ...
const [result, setResult] = React.useState();

React.useEffect(() => {
  Liphy.startTracking();
  const removeListener = Liphy.addEventListener((data) => {
    setResult(data.lightId);
  });
  return () => {
    removeListener();
  };
}, []);
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
