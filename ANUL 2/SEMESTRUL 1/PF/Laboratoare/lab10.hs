newtype Identity a = Identity a
data Pair a = Pair a a
data Constant a b = Constant b
data Two a b = Two a b
data Three a b c = Three a b c
data Three' a b = Three' a b b
data Four a b c d = Four a b c d
data Four'' a b = Four'' a a a b
data Quant a b = Finance | Desk a | Bloor b

instance Functor Identity where
    fmap f (Identity x) = Identity (f x)

instance Functor Pair where
    fmap f (Pair x y) = Pair (f x) (f y)

instance Functor (Constant a) where
    fmap f (Constant x) = Constant (f x)

instance Functor (Two a) where
     fmap f (Two x y) = Two x (f y)

instance Functor (Three a b) where
    fmap f (Three x y z) = Three x y (f z)

instance Functor (Three' a) where
    fmap f (Three' x y z) = Three' x (f y) (f z)

instance Functor (Four a b c) where
    fmap f (Four x y z t) = Four x y z (f t)

instance Functor (Four'' a) where
    fmap f (Four'' x y z t) = Four'' x y z (f t)

instance Functor (Quant a) where
    fmap f Finance = Finance
    fmap f (Desk x) = Desk x
    fmap f (Bloor y) = Bloor (f y)

data LiftItOut f a = LiftItOut (f a)
    deriving Show;
data Parappa f g a = DaWrappa (f a) (g a)
    deriving Show;
data IgnoreOne f g a b = IgnoringSomething (f a) (g b)
    deriving Show;
data Notorious g o a t = Notorious (g o) (g a) (g t)
    deriving Show;
data GoatLord a = NoGoat | OneGoat a | MoreGoats (GoatLord a) (GoatLord a) (GoatLord a)
    deriving Show;
data TalkToMe a = Halt | Print String a | Read (String -> a)

instance Functor f => Functor (LiftItOut f) where
    fmap f1 (LiftItOut x) = LiftItOut (fmap f1 x)

instance (Functor f, Functor g) => Functor (Parappa f g) where
    fmap f1 (DaWrappa x y) = DaWrappa (fmap f1 x) (fmap f1 y)

instance (Functor f, Functor g) => Functor (IgnoreOne f g a) where
    fmap f1 (IgnoringSomething x y) = IgnoringSomething x (fmap f1 y)

instance (Functor g) => Functor (Notorious g o a) where
    fmap f1 (Notorious x y z) = Notorious x y (fmap f1 z)

instance Functor GoatLord where
    fmap f1 NoGoat = NoGoat
    fmap f1 (OneGoat x) = OneGoat (f1 x)
    fmap f1 (MoreGoats x y z) = MoreGoats (fmap f1 x) (fmap f1 y) (fmap f1 z)

instance Functor TalkToMe where
    fmap f1 Halt = Halt
    fmap f1 (Print x y) = Print x (f1 y)
    fmap f1 (Read f) = Read (fmap f1 f)