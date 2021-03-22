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

## Usage

```js
import Liphy from "react-native-liphy";

// ...

const result = await Liphy.multiply(3, 7);
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
