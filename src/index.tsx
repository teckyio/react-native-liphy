import { NativeModules } from 'react-native';

type LiphyType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Liphy } = NativeModules;

export default Liphy as LiphyType;
